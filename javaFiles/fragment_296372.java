public class test {
{
  private int[][] matrix;

  public void pideDatos() {
    int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuántas filas?", "Iniciando", JOptionPane.QUESTION_MESSAGE));
    int columna = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuántas columnas?", "Iniciando", JOptionPane.QUESTION_MESSAGE));
    matrix = new int[fila][columna];
  }
}