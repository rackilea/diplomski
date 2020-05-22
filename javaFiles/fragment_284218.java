public UI_Controller(UI_Model model, UI_View view)
{
    ui_model = model;
    ui_view  = view;

    ui_model.addObserver(ui_view);

    ui_view.towersBoxListener(new towerSelectionListener());
    ui_view.modulesTreeListener(new modulesSelectionListener());
    ui_view.browserListListener(new browserSelectionListener());
    ui_view.towerLabelListner(new towerRemovalListener());
}