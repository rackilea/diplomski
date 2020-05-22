import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                MenuPane menuPane = new MenuPane();
                DefaultMenuController controller = new DefaultMenuController(menuPane);

                SubMenuPane ebanking = new SubMenuPane("E-Banking");
                ebanking.addAction(new AbstractMenuAction(controller, "Deposit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getController().popLastMenu();
                        SubMenuPane deposit = new SubMenuPane("Options").addAction(new AbstractMenuAction(getController(), "Request") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        }).addAction(new AbstractMenuAction(getController(), "Query") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        });
                        getController().addSubMenu(deposit);
                    }
                }).addAction(new AbstractMenuAction(controller, "Credit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getController().popLastMenu();
                        SubMenuPane deposit = new SubMenuPane("Credit-Options").addAction(new AbstractMenuAction(getController(), "Request") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        }).addAction(new AbstractMenuAction(getController(), "Query") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        });
                        getController().addSubMenu(deposit);
                    }
                }).addAction(new AbstractMenuAction(controller, "Exchange") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getController().popLastMenu();
                        SubMenuPane deposit = new SubMenuPane("Exchange-Options").addAction(new AbstractMenuAction(getController(), "Request") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        }).addAction(new AbstractMenuAction(getController(), "Query") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        });
                        getController().addSubMenu(deposit);
                    }
                }).addAction(new AbstractMenuAction(controller, "Simulation") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getController().popLastMenu();
                        SubMenuPane deposit = new SubMenuPane("Simulation-Options").addAction(new AbstractMenuAction(getController(), "Request") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        }).addAction(new AbstractMenuAction(getController(), "Query") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        });
                        getController().addSubMenu(deposit);
                    }
                }).addAction(new AbstractMenuAction(controller, "Information") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getController().popLastMenu();
                        SubMenuPane deposit = new SubMenuPane("Information-Options").addAction(new AbstractMenuAction(getController(), "Request") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        }).addAction(new AbstractMenuAction(getController(), "Query") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Use Card layout to show next avaliable options
                            }
                        });
                        getController().addSubMenu(deposit);
                    }
                });
                controller.addSubMenu(ebanking);

                JPanel someContent = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(200, 200);
                    }
                };
                someContent.setBackground(Color.RED);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(menuPane, BorderLayout.WEST);
                frame.add(someContent);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface MenuController {

        public void addSubMenu(SubMenuPane subMenuPane);

        public void popLastMenu();
    }

    public class DefaultMenuController implements MenuController {

        private MenuPane menuPane;

        public DefaultMenuController(MenuPane menuPane) {
            this.menuPane = menuPane;
        }

        @Override
        public void addSubMenu(SubMenuPane subMenuPane) {
            menuPane.addSubMenuPane(subMenuPane);
        }

        @Override
        public void popLastMenu() {
            menuPane.popLastMenu();
        }

    }

    public interface MenuAction extends Action {

        public MenuController getController();
    }

    public abstract class AbstractMenuAction extends AbstractAction implements MenuAction {

        private MenuController controller;

        public AbstractMenuAction(MenuController controller, String name) {
            this.controller = controller;
            putValue(NAME, name);
        }

        @Override
        public MenuController getController() {
            return controller;
        }

    }

    public class MenuPane extends JPanel {

        public MenuPane() {
            setLayout(new GridBagLayout());
        }

        public void addSubMenuPane(SubMenuPane pane) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.weighty = 1;
            add(pane, gbc);

            revalidate();
            repaint();
        }

        public void removeSubMenu(SubMenuPane pane) {
            remove(pane);
            revalidate();
            repaint();
        }

        public void popLastMenu() {
            if (getComponentCount() == 1) {
                return;
            }
            remove(getComponent(getComponentCount() - 1));
            revalidate();
            repaint();
        }

    }

    public class SubMenuPane extends JPanel {

        public SubMenuPane(String name) {
            setLayout(new GridLayout(0, 1));
            setBorder(new LineBorder(Color.DARK_GRAY));
            add(new JLabel(name, JLabel.CENTER));
        }

        public SubMenuPane addAction(MenuAction action) {
            JButton btn = new JButton(action);
            add(btn);
            return this;
        }

        public void pop() {
            Container parent = getParent();
            if (parent != null) {
                parent.remove(this);
                parent.revalidate();
                parent.repaint();
            }
        }

    }

}