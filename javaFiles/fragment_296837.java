package stackoverflow.questions;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class ParentChildApp {

   public static class Entry {

      private String name;

      public Entry(String name) {
         this.name = name;
      }

      private List<Entry> children;

      public void add(Entry node){
         if (children == null)
            children = new ArrayList<Entry>();
         children.add(node);
      }

   }

   public static void main(String[] args) {

      Entry workNode = new Entry("Work");
      workNode.add(new Entry("Effort"));
      workNode.add(new Entry("Trust"));

      Entry salaryNode = new Entry("Salary");


      Entry cultureNode = new Entry("Culture");
      cultureNode.add(salaryNode);
      cultureNode.add(workNode);

      Gson g = new Gson();

      System.out.println(g.toJson(cultureNode));
   }

}