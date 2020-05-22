import org.eclipse.fx.ui.services.theme.ThemeManager;

@Inject
ThemeManager themeManager;

ObservableList<URL> stylesheets =  themeManager.getCurrentTheme().getStylesheetURL();