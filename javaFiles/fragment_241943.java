<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //after generating your list

  Gson gson = new Gson();
  JsonObject root = new JsonObject();
  root.addProperty("flag", flag); //add flag
  root.addProperty("list", gson.toJson(list)); //add list

  out.println(gson.toJson(root));
  out.flush();
%>