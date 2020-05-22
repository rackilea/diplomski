reatachIframe(uploadForm);

private native static void reatachIframe(FormPanel form) /*-{
  var i = form.@com.google.gwt.user.client.ui.FormPanel::synthesizedFrame;
  var o = i.onload;
  i.onload = undefined;
  var p = i.parentElement;
  p.removeChild(i);
  p.appendChild(i);
  i.onload = o;
}-*/;