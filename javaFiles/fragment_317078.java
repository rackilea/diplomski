HorizontalLayout layout = new HorizontalLayout();
layout.setWidthFull();
VerticalLayout left = new VerticalLayout(new Span("LEFT"));
VerticalLayout right = new VerticalLayout(new Span("RIGHT"));
left.setSizeUndefined();
right.setSizeUndefined();

layout.add(left, right);
layout.setPadding(false);
layout.setMargin(false);
layout.setFlexGrow(1.0, left);
layout.setFlexGrow(0,right);
add(layout);