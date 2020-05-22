trait FindView
{
    this: Activity =>

    def findView [WidgetType] (id: Int) : WidgetType = {
        return findViewById (id).asInstanceOf[WidgetType]
    }

    implicit def listenerFromFunction (action: () => Any) = {
        new View.OnClickListener() {
            def onClick(v: View) {action ()}
        }
    }
}