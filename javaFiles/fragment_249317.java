import java.util.Arrays;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.renderers.swt.SWTRenderersMessages;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.renderers.swt.StackRenderer;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class UndetachableStackRenderer extends StackRenderer
{
    @Inject 
    private IEclipseContext context;

    @PostConstruct
    public void init() 
    {
        super.init(context);
    }

    @Override 
    protected void populateTabMenu(final Menu menu, final MPart part)
    {
        super.populateTabMenu(menu, part);

        final MenuItem[] menuItems = menu.getItems();

        final Optional<MenuItem> detachMenuItem = Arrays.stream(menuItems).filter(item -> item.getText().equals(SWTRenderersMessages.menuDetach)).findFirst();

        if(detachMenuItem.isPresent())
        {
            detachMenuItem.get().dispose();
        }
    }
}