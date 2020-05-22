// With option 1, you only receive Widgets - even
// from a SpecificWidgetHolder
List<? extends Widget> widgets = specificWidgetHolder.getWidgets();
Widget widget = widgets.get(0);

// With option 3., you still know that a SpecificWidgetHolder
// provides a list of SpecificWidgets
List<? extends SpecificWidget> specificWidgets = specificWidgetHolder.getWidgets();
SpecificWidget specificWidget = specificWidgets.get(0);