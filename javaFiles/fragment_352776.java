public class ALItensValues {
  private int icon;
  private String value;
  private String titulo;
  private String descricao;
  private Boolean isChecked;

  public ALItensValues(int icon, String value, String titulo, String descricao, Boolean isChecked) {
   this.icon = icon;
   this.value = value;
   this.titulo = titulo;
   this.descricao = descricao;
   this.isChecked = isChecked;
  }

  int getIcon() { return icon; }
  String getValue() { return value; }
  String getTitulo() { return titulo; }
  String getDescricao() { return descricao; }
  Boolean getChecked() { return isChecked; }
  void setChecked(Boolean isChecked) {
    this.isChecked = isChecked;
  }
}