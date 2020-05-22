import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;

public class MP2_1 extends JFrame {
    private JList leftlist;
    private JList rightlist;

    private JButton addbutton;
    private JButton totalbutton;
    private JLabel totalLabel;


    public MP2_1() {

        super("MP2_1");
        setLayout(new FlowLayout());

        // preparing item list it might be coming from somewhere else
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Item 1", 100));
        itemList.add(new Item("Item 2", 400));
        itemList.add(new Item("Item 3", 500));
        itemList.add(new Item("Item 4", 600));
        itemList.add(new Item("Item 5", 800));
        itemList.add(new Item("Item 6", 300));
        itemList.add(new Item("Item 7", 200));
        itemList.add(new Item("Item 8", 300));
        itemList.add(new Item("Item 9", 400));

        leftlist = new JList(itemList.toArray());
        leftlist.setVisibleRowCount(5);
        leftlist
                .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftlist));

        addbutton = new JButton("ADD");
        addbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //make sure you preserve the previously selected list items
                int size = rightlist.getModel().getSize();
                Set objects = new LinkedHashSet();
                for (int i = 0; i < size; i++) {
                    objects.add(rightlist.getModel().getElementAt(i));
                }
                objects.addAll(Arrays.asList(leftlist.getSelectedValues()));

                rightlist.setListData(objects.toArray());
            }
        });
        add(addbutton);

        rightlist = new JList();
        rightlist.setVisibleRowCount(5);
        rightlist.setFixedCellWidth(55);
        rightlist.setFixedCellHeight(20);
        add(new JScrollPane(rightlist));

        totalbutton = new JButton("Total");
        totalbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // iterate over item objects and calculate the total
                int size = rightlist.getModel().getSize();
                Integer totalAmount = 0;
                for (int i = 0; i < size; i++) {
                    Object obj = leftlist.getModel().getElementAt(i);
                    Item item = (Item) obj;
                    totalAmount += item.getItemPrice();
                }
                //update the total Amount label
                totalLabel.setText("Total Amount : " + totalAmount);
            }
        });
        add(totalbutton);

        totalLabel = new JLabel("Total Amount : ");

        add(totalLabel);

    }

    public static void main(String[] args) {
        MP2_1 list = new MP2_1();
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list.setSize(300, 300);
        list.setVisible(true);
    }
}