am.put(key, new MyNewOnEnterAction(insertBreak));

//...

public class MyNewOnEnterAction extends AbstractAction {

    private Action proxy;

    public MyNewOnEnterAction(Action proxy) {
        this.proxy = proxy;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Your custom functionality here...
        proxy.actionPerformed(e);
    }

}