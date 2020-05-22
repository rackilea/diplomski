import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ImmutableClassToInstanceMap;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class ActionHandler {

    private static final ClassToInstanceMap<Action> actionMap =
            new ImmutableClassToInstanceMap.Builder<Action>().
                    put(DefaultEditorKit.CutAction.class, new DefaultEditorKit.CutAction()).
                    put(DefaultEditorKit.CopyAction.class, new DefaultEditorKit.CopyAction()).
                    put(DefaultEditorKit.PasteAction.class, new DefaultEditorKit.PasteAction()).
                    put(RefreshAction.class, new RefreshAction()).
                    put(MinimizeAction.class, new MinimizeAction()).
                    put(ZoomAction.class, new ZoomAction()).
                    build();

    public static Action getActionFor(Class<? extends Action> actionClasss) {
        return actionMap.getInstance(actionClasss);
    }
}