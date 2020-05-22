package wishminimal.ui.home;

import java.util.Iterator;

import org.apache.wicket.PageParameters;
import org.apache.wicket.devutils.stateless.StatelessComponent;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import wishminimal.dao.PostDAO;
import wishminimal.entity.Post;

@StatelessComponent
public class HomePage extends WebPage {

    @SpringBean
    PostDAO postDAO;

    ISortableDataProvider<Post> dataProvider = new SortableDataProvider<Post>() {
        public Iterator<? extends Post> iterator(int first, int count) {
            return postDAO.findAll(first, count).iterator();
        }
        public int size() {
            return postDAO.countAll();
        }
        public IModel<Post> model(Post object) {
            return new CompoundPropertyModel<Post>(object);
        }
    };

    public HomePage(PageParameters params) {
        final int currentPage = params.getAsInteger("p", 0);

        final DataView<Post> dataView = new DataView<Post>("posts", dataProvider, 10) {
            @Override
            protected void populateItem(Item<Post> item) {
                item.add(new Label("title"));
                item.add(new Label("content"));
                item.add(new Label("date"));
            }
        };
        dataView.setCurrentPage(currentPage);
        add(dataView);

        add(new BookmarkablePageLink<Void>("recentPosts", getClass(), new PageParameters("p=" + (currentPage - 1))) {
            @Override
            public boolean isVisible() {
                return currentPage > 0;
            }
        });
        add(new BookmarkablePageLink<Void>("previousPosts", getClass(), new PageParameters("p=" + (currentPage + 1))) {
            @Override
            public boolean isVisible() {
                return currentPage < dataView.getPageCount();
            }
        });
    }
}