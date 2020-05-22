interface Widget {}

interface WidgetFactory {
    Widget get();
}

class LargeWidget implements Widget {}

class SmallWidget implements Widget {}