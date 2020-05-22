import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.GoAndClearFilter;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilter;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Martin Strejc
 *
 */
public class FilterPage extends WebPage {

    private static final long serialVersionUID = 1L;

    public FilterPage() {
        super();
        MySortableDataProvider dataProvider = new MySortableDataProvider();
        FilterForm<Entity> filterForm = new FilterForm<>("filterForm", dataProvider);
        List<IColumn<Entity, Entity>> columns = new LinkedList<>();
        // default filter by auto convert detection
        columns.add(new TextFilteredPropertyColumn<FilterPage.Entity, FilterPage.Entity, FilterPage.Entity>(Model.of("Start Date"), dataProvider.getFilterState(), "start"));

        columns.add(new TextFilteredPropertyColumn<FilterPage.Entity, FilterPage.Entity, FilterPage.Entity>(Model.of("Finish Date"), dataProvider.getFilterState(), "finish") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component getFilter(String componentId, FilterForm<?> form) {
                @SuppressWarnings({ "unchecked", "rawtypes" })
                TextFilter<Date> filter = new TextFilter(componentId, getFilterModel(form), form);
                filter.getFilter().add(new DatePicker());
                return filter;
            }

        });

        // default filtering of String
        columns.add(new TextFilteredPropertyColumn<FilterPage.Entity, FilterPage.Entity, FilterPage.Entity>(Model.of("Note"), dataProvider.getFilterState(), "note"));
        DefaultDataTable<Entity, Entity> table = new DefaultDataTable<>("table", columns, dataProvider, Integer.MAX_VALUE);
        FilterToolbar filterToolbar = new FilterToolbar(table, filterForm, dataProvider);
        table.addTopToolbar(filterToolbar);
        filterForm.add(table);
        filterForm.add(new GoAndClearFilter("goAndClear", filterForm));
        add(filterForm);
        add(new MyFilterResult("filterResult", filterForm.getModel()));

    }

    /**
     * My own sortable data provider implementation,
     * this implementation just provide a fixe list of data
     * without any real sorting. 
     * 
     * @author Martin Strejc
     *
     */
    public static class MySortableDataProvider extends SortableDataProvider<Entity, Entity> implements IFilterStateLocator<Entity> {

        private static final long serialVersionUID = 1L;

        private final List<Entity> list;
        private List<Entity> filteredList;

        private Entity filterState = new Entity();

        /**
         * The default constructor that creates the list
         */
        public MySortableDataProvider() {
            super();
            list = new ArrayList<>(5);
            list.add(new Entity(new GregorianCalendar(2013, 5, 3).getTime(), new GregorianCalendar(2013, 5, 10).getTime(), "the first field"));
            list.add(new Entity(new GregorianCalendar(2013, 5, 3).getTime(), new GregorianCalendar(2013, 5, 13).getTime(), "the second field"));
            list.add(new Entity(new GregorianCalendar(2013, 7, 3).getTime(), new GregorianCalendar(2013, 8, 12).getTime(), "the middler field"));
            list.add(new Entity(new GregorianCalendar(2013, 8, 3).getTime(), new GregorianCalendar(2013, 8, 10).getTime(), "the field no. 4"));
            list.add(new Entity(new GregorianCalendar(2013, 11, 3).getTime(), new GregorianCalendar(2013, 12, 2).getTime(), "the last field"));
        }

        public List<Entity> createFilteredList() {
            List<Entity> ret = new LinkedList<>();
            for(Entity e : list) {
                if(filterState != null) {
                    if(filterState.getStart() != null && !filterState.getStart().equals(e.getStart())) {
                        continue;
                    }
                    if(filterState.getFinish() != null && !filterState.getFinish().equals(e.getFinish())) {
                        continue;
                    }
                    if(filterState.getNote() != null && !filterState.getNote().equals(e.getNote())) {
                        continue;
                    }
                }
                ret.add(e);
            }
            return ret;
        }

        public List<Entity> getFilteredList() {
            if(filteredList == null) {
                filteredList = createFilteredList();
            }
            return filteredList;
        }

        @Override
        public Iterator<? extends Entity> iterator(long first, long count) {
            return getFilteredList().iterator();
        }

        @Override
        public long size() {
            return getFilteredList().size();
        }

        @Override
        public IModel<Entity> model(Entity object) {
            return Model.of(object);
        }

        @Override
        public Entity getFilterState() {
            return filterState;
        }

        @Override
        public void setFilterState(Entity state) {
            this.filterState = state;
        }

        @Override
        public void detach() {
            super.detach();
            filteredList = null;
        }

    }

    public static class MyFilterResult extends WebMarkupContainer {

        private static final long serialVersionUID = 1L;

        /**
         * @param id
         * @param model
         */
        public MyFilterResult(String id, IModel<Entity> model) {
            super(id, CompoundPropertyModel.of(model));
            add(new Label("start"));
            add(new Label("finish"));
            add(new Label("note"));
        }


    } 

    /**
     * The entity class represent any entity 
     * that's usable as a model object
     *  
     * @author Martin Strejc
     *
     */
    public static class Entity implements Serializable {

        private static final long serialVersionUID = 1L;

        private Date start;
        private Date finish;
        private String note;


        /**
         * Default constructor 
         */
        public Entity() {
            super();
        }


        /**
         * Constructor from all entity fields
         * 
         * @param start
         * @param finish
         * @param note
         */
        public Entity(Date start, Date finish, String note) {
            super();
            this.start = start;
            this.finish = finish;
            this.note = note;
        }


        /**
         * @return the start
         */
        public Date getStart() {
            return start;
        }
        /**
         * @param start the start to set
         */
        public void setStart(Date start) {
            this.start = start;
        }
        /**
         * @return the finish
         */
        public Date getFinish() {
            return finish;
        }
        /**
         * @param finish the finish to set
         */
        public void setFinish(Date finish) {
            this.finish = finish;
        }
        /**
         * @return the note
         */
        public String getNote() {
            return note;
        }
        /**
         * @param note the note to set
         */
        public void setNote(String note) {
            this.note = note;
        }

    }

}