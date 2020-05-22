@Component
public class ProdutoEditor extends PropertyEditorSupport {
  @Override
  public void setAsText(String text) {
    if (!text.equals("")) {
      ProdutoService serv = new ProdutoService();
      ApplicationContextHolder.getContext().getAutowireCapableBeanFactory().autowireBean(serv);
      Produto produto = serv.getObject(text);
      setValue(produto);
    } else {
      setValue(null);
    }
  }
}