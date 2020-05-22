package com.joseph.dao;

import java.util.List;

import com.joseph.model.Student;

public interface StudentDao {
   void add(Student student);
   void edit(Student student);
   void delete(int studentId);
   Student getStudent(int studentId);
   List getAllStudent();
}