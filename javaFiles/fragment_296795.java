package Controller;

import Model.Data;
import View.Frame;

public class Controller{
 private Frame frame;
 private Data data;
  
 //controller
 private GraphCtrl graphCtrl;
 private MenuCtrl menuCtrl;
 private EditCtrl editCtrl;
 private TableCtrl tableCtrl;
  
 //builder
 public Controller(Frame frame, Data data){
  this.frame=frame;
  this.data=data;
  build();
 }
 public void build(){
  graphCtrl = new GraphCtrl(frame.getPanelG(), data);
  menuCtrl = new MenuCtrl(frame, data);
  editCtrl = new EditCtrl(frame.getPanelS().getPanelEdit(), frame.getPanelG(), data);
  tableCtrl = new TableCtrl(frame.getPanelS().getPanelTable(), frame.getPanelG(), data);
 }
}