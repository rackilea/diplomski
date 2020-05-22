@Route("dialogs-tabs")
public class DialogContainerTabs extends VerticalLayout {
    public DialogContainerTabs(){
        Dialog dialog=new Dialog();

        Tab tab1 = new Tab("Tab one");
        Div page1 = new Div();
        page1.setText("Page#1");

        Tab tab2 = new Tab("Tab two");
        Div page2 = new Div();
        page2.setText("Page#2");
        page2.setVisible(false);

        Tab tab3 = new Tab("Tab three");
        Div page3 = new Div();
        page3.setText("Page#3");
        page3.setVisible(false);

        Map<Integer, Component> tabsToPages = new HashMap<>();
        tabsToPages.put(0, page1);
        tabsToPages.put(1, page2);
        tabsToPages.put(2, page3);
        Tabs tabs = new Tabs(tab1, tab2, tab3);
        Div pages = new Div(page1, page2, page3);
        Set<Component> pagesShown = Stream.of(page1)
                .collect(Collectors.toSet());

        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Component selectedPage = tabsToPages.get(tabs.getSelectedIndex());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });

        Button back=new Button();
        back.setIcon(VaadinIcon.ARROW_BACKWARD.create());
        dialog.add(back);
        back.addClickListener(e->{
           if(tabs.getSelectedIndex()>0){
               pagesShown.forEach(page -> page.setVisible(false));
               pagesShown.clear();
               tabs.setSelectedIndex(tabs.getSelectedIndex()-1);
               Component selectedPage = tabsToPages.get(tabs.getSelectedIndex());
               selectedPage.setVisible(true);
               pagesShown.add(selectedPage);
           }
           else{
               //Do what you want, maybe navigate to the last one? or NOOP
           }
        });


        Button forward=new Button();
        forward.setIcon(VaadinIcon.ARROW_FORWARD.create());
        dialog.add(forward);
        forward.addClickListener(e->{
            if(tabs.getSelectedIndex()<tabsToPages.size()-1){
                pagesShown.forEach(page -> page.setVisible(false));
                pagesShown.clear();
                tabs.setSelectedIndex(tabs.getSelectedIndex()+1);
                Component selectedPage = tabsToPages.get(tabs.getSelectedIndex());
                selectedPage.setVisible(true);
                pagesShown.add(selectedPage);
            }
            else{
                //Do what you want, maybe navigate to the first one one? or NOOP
            }
        });


        dialog.add(tabs);
        dialog.add(pages);
        dialog.setOpened(true);
        add(dialog);
    }

}