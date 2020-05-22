public class SimpleTabPanel extends com.sencha.gxt.widget.core.client.PlainTabPanel
    implements TabPanel {
Tab currentActiveTab;

private Map<SimpleTab,TabItemConfig> tabConfigs = new HashMap<SimpleTab,TabItemConfig>();



// a map sorted by priority used to keep the expected tab order
SortedMap<TabData, SimpleTab> tabsConfig = new TreeMap<TabData, SimpleTab>(
        new Comparator<TabData>() {
            @Override
            public int compare(TabData o1, TabData o2) {
                return Float.compare(o1.getPriority(), o2.getPriority());
            }
        });

@Override
public Tab addTab(TabData tabData, String historyToken) {
    SimpleTab newTab = createNewTab(tabData);
    tabsConfig.put(tabData, newTab);
    newTab.setTargetHistoryToken(historyToken);
    return newTab;
}


private void disableTab(SimpleTab tab, TabData key){

    // get and save tab's config.
    TabItemConfig tic = getConfig(tab);
    tabConfigs.put(tab, tic);

    // put new one on tab to disable it.
    tic = new TabItemConfig(key.getLabel());
    tic.setEnabled(false);
    update(tab, tic);
}

public void enableAllTabs(){
    for(TabData key : tabsConfig.keySet()){
        SimpleTab tab = tabsConfig.get(key);
        TabItemConfig tic = tabConfigs.get(tab);
        if(tic!=null){
            tic.setEnabled(true);
            update(tab, tic);
        }
    }
}