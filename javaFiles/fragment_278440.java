package org.combobox;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboPanel extends JPanel  {
  private static final long serialVersionUID = 1L;

  private static final String DEPARTMENT = "Department";
  private static final String PROGRAM = "Program";
  private static final String FACULTY = "Faculty";
  private static final String ACADEMIC_RANK = "Academic Rank";

  private JComboBox<CleanNode> _department;
  private JComboBox<CleanNode> _program;
  private JComboBox<CleanNode> _faculty;
  private JComboBox<CleanNode> _rank;

  private DependencyLink _rankLink;
  private DependencyLink _facultyLink;
  private DependencyLink _programLink;
  private DependencyLink _departmentLink;

  public ComboPanel(CleanNode root) {
    super(new BorderLayout());
    addCombos(root);
  }

  private void addCombos(CleanNode root) {
    _department = new JComboBox<CleanNode>();
    _program = new JComboBox<CleanNode>();
    _faculty = new JComboBox<CleanNode>();
    _rank = new JComboBox<CleanNode>();

    _rankLink = new DependencyLink(_rank, null);
    _facultyLink = new DependencyLink(_faculty, _rankLink);
    _programLink = new DependencyLink(_program, _facultyLink);
    _departmentLink = new DependencyLink(_department, _programLink);
    _departmentLink.populate(root);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(4, 2));
    panel.add(new JLabel("                            " + DEPARTMENT + " : "));
    panel.add(_department);
    panel.add(new JLabel("                               " + PROGRAM + " : "));
    panel.add(_program);
    panel.add(new JLabel("                               " + FACULTY + " : "));
    panel.add(_faculty);
    panel.add(new JLabel("                         " + ACADEMIC_RANK + " : "));
    panel.add(_rank);

    add(panel, BorderLayout.CENTER);
  }
}