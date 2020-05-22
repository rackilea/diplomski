package org.combobox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;

public class DependencyLink implements ActionListener {

  private boolean _isLocked;
  private JComboBox<CleanNode>_combo;
  private DependencyLink _childLink;
  private CleanNode _previousNode;

  public DependencyLink(JComboBox<CleanNode>combo, DependencyLink childLink) {
    _combo = combo;
    _combo.addActionListener(this);
    _childLink = childLink;
  }

  public void actionPerformed(ActionEvent e) {
    CleanNode node = (CleanNode)_combo.getSelectedItem();
    if(node != _previousNode) {
      updateChild();
      _previousNode = node;
    }
  }

  private void updateChild() {
    if( _childLink != null) {
      if(!_isLocked) {
        _childLink.populate((CleanNode)_combo.getSelectedItem());
      }
    }
  }

  public void populate(CleanNode parentNode) {
    _isLocked = true;
    _combo.removeAllItems();
    if(parentNode != null) {
      List<CleanNode> children = parentNode.getNodes();
      if(!children.isEmpty()) {
        for(CleanNode childNode : children) {
          _combo.addItem(childNode);
        }
        _combo.setSelectedItem(children.get(0));
      }
    }
    _isLocked = false;
    updateChild();
  }
}