class Foo extends javax.swing.undo.UndoManager {
  def edits(): java.util.Vector[javax.swing.undo.UndoableEdit] =
    classOf[javax.swing.undo.CompoundEdit].
    getDeclaredField("edits").get(this).
    asInstanceOf[java.util.Vector[javax.swing.undo.UndoableEdit]]
}