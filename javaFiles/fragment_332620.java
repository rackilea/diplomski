public class RepeatDrop
{
    private Shell        shell;
    private Display      display;
    private final Label  lblUnicorn;
    private final Canvas canvas;

    public static void main(String args[])
    {
        new RepeatDrop();
    }

    public RepeatDrop()
    {
        display = new Display();
        shell = new Shell(display);
        shell.setText("SWT Application");
        shell.setLayout(new GridLayout(2, false));

        Group grpPalette = new Group(shell, SWT.NONE);
        grpPalette.setText("Palette");
        grpPalette.setLayout(new GridLayout());
        grpPalette.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

        lblUnicorn = new Label(grpPalette, SWT.BORDER | SWT.HORIZONTAL | SWT.CENTER);
        lblUnicorn.setText("UNICORN");
        // ADDED A FINAL HERE!!
        lblUnicorn.setAlignment(SWT.CENTER);

        final Group grpCanvas = new Group(shell, SWT.NONE);
        grpCanvas.setText("Canvas");
        grpCanvas.setLayout(new GridLayout());
        grpCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        canvas = new Canvas(grpCanvas, SWT.NONE);
        canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        LightweightSystem lws = new LightweightSystem(canvas); //
        final IFigure panel = new Figure(); //
        lws.setContents(panel); //

        DragSource dragSource1 = new DragSource(lblUnicorn, DND.DROP_COPY);
        Transfer[] transfers1 = new Transfer[] { TextTransfer.getInstance() };
        dragSource1.setTransfer(transfers1);
        dragSource1.addDragListener(new DragSourceListener()
        {
            public void dragStart(DragSourceEvent event)
            {
                if (lblUnicorn.getText().length() == 0)
                {
                    event.doit = false;
                }
            }

            public void dragSetData(DragSourceEvent event)
            {
                if (TextTransfer.getInstance().isSupportedType(event.dataType))
                {
                    event.data = lblUnicorn.getText();
                }
            }

            public void dragFinished(DragSourceEvent event)
            {
            }
        });

        Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
        DropTarget dropTarget = new DropTarget(canvas, DND.DROP_COPY | DND.DROP_DEFAULT);
        dropTarget.setTransfer(types);

        dropTarget.addDropListener(new DropTargetListener()
        {
            public void dragEnter(DropTargetEvent event)
            {
                if (event.detail == DND.DROP_DEFAULT)
                {
                    if ((event.operations & DND.DROP_COPY) != 0)
                    {
                        event.detail = DND.DROP_COPY;
                    }
                    else
                    {
                        event.detail = DND.DROP_NONE;
                    }
                }
            }

            public void dragLeave(DropTargetEvent event)
            {
            }

            public void dragOperationChanged(DropTargetEvent event)
            {
            }

            public void dragOver(DropTargetEvent event)
            {
            }

            public void drop(DropTargetEvent event)
            {
            }

            public void dropAccept(final DropTargetEvent event)
            {

                if (TextTransfer.getInstance().isSupportedType(event.currentDataType))
                {
                    String d = (String) TextTransfer.getInstance().nativeToJava(event.currentDataType);

                    org.eclipse.swt.graphics.Point droppoint = canvas.toControl(event.x, event.y);

                    // DRAW 2D SECTION
                    RectangleFigure node1 = new RectangleFigure();
                    Rectangle rect = new Rectangle(droppoint.x, droppoint.y, 20, 20);
                    Rectangle rect2 = new Rectangle(droppoint.x, droppoint.y, 100, 25);
                    node1.setBounds(rect);
                    node1.setBackgroundColor(ColorConstants.cyan);

                    org.eclipse.draw2d.Label droppedName = new org.eclipse.draw2d.Label(d);
                    droppedName.setLocation(new Point(droppoint.x, droppoint.y)); // draw2d.
                                                                                  // point
                    droppedName.setBounds(rect2);

                    node1.add(droppedName);
                    panel.add(node1);
                    panel.add(droppedName);

                    new Dragger(node1);
                    new Dragger(droppedName);

                    canvas.redraw();
                }
            }
        });

        shell.pack();
        shell.setSize(400, 300);
        shell.open();

        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    static class Dragger extends MouseMotionListener.Stub implements MouseListener
    {
        public Dragger(IFigure figure)
        {
            figure.addMouseMotionListener(this);
            figure.addMouseListener(this);
        }

        Point last;

        public void mouseReleased(MouseEvent e)
        {
        }

        public void mouseClicked(MouseEvent e)
        {
        }

        public void mouseDoubleClicked(MouseEvent e)
        {
        }

        public void mousePressed(MouseEvent e)
        {
            last = e.getLocation();
        }

        public void mouseDragged(MouseEvent e)
        {
            Point p = e.getLocation();
            Dimension delta = p.getDifference(last);
            {
                last = p;
                Figure f = ((Figure) e.getSource());
                f.setBounds(f.getBounds().getTranslated(delta.width, delta.height));
            }
        }
    }
}