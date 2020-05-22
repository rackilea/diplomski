class PreFoo extends javax.swing.undo.UndoManager {
  protected def editz = edits
}
class RealFoo extends PreFoo {
  def edits() = editz
}