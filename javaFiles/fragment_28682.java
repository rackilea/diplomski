/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



/**
 *
 * @author asterisk
 */
class Matrix {

    double[][] element;
    int rows, cols;

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        element = new double[rows][cols];
    }

    public double getValue(int row, int col) {
        return element[row][col];
    }

    public void setValue(int row, int col, double value) {
        element[row][col] = value;
    }

    public int getNoRows() {  // returns the total number of rows
        return rows;
    }

    public int getNoCols() { // returns the total number of cols
        return cols;
    }

// The methods for the main calculations
    public Matrix AddMatrix(Matrix m2) {
        int row1 = getNoRows();
        int col1 = getNoCols();
        Matrix result = new Matrix(row1, col1);

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                result.setValue(i, j, this.getValue(i, j) + m2.getValue(i, j));
            }
        }
        return result;
    }

    public Matrix MultiplyMatrix(Matrix m2) {
        if (this.getNoCols() != m2.getNoRows()) {
            throw new IllegalArgumentException("matrices can't be multiplied");
        }
        int row2 = this.getNoRows();
        int col2 = m2.getNoCols();
        Matrix result = new Matrix(row2, col2);
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                result.setValue(i, j, result.getValue(i, j) + this.getValue(i, j) * m2.getValue(i, j));
            }
        }
        return result;

    }

    public Matrix TransposeMatrix() {
        int row3 = this.getNoCols();
        int col3 = this.getNoRows();
        Matrix result = new Matrix(row3, col3);
        for (int i = 0; i < row3; i++) {
            for (int j = 0; j < col3; j++) {
                result.setValue(i, j, this.getValue(j, i));
            }
        }
        return result;

    }

    public void DisplayMatrix() {
        for (int i = 0; i < this.getNoRows(); i++) {
            for (int j = 0; j < this.getNoCols();
                    j++) {
                System.out.print((this.getValue(i, j)) + " ");
            }
            System.out.print("\n");
        }
    }
}



public class Lab1 {

    public static void main(String args[]) throws FileNotFoundException {
        //      Matrix  m1 = new Matrix();
//          Matrix  m2 = new Matrix();
        //         Matrix  m3 = new Matrix();

        System.out.println("1. Add two matrices \n");
        System.out.println("2. Subtract two matrices \n");
        System.out.println("3. Take transpose of a matrix \n");
        System.out.println("4. Display a matrix \n");
        System.out.println("5. Exit \n");

        int choice;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choice /n");
        choice = in.nextInt();

        Matrix m1 = MatrixReader();
        m1.DisplayMatrix();
        Matrix m2 = MatrixReader();
        m2.DisplayMatrix();


        if (choice == 1) {
            Matrix m3 = new Matrix(m1.getNoRows(), m1.getNoCols());
            m3 = m1.AddMatrix(m2);
            m3.DisplayMatrix();
        }

        if (choice == 2) {
            Matrix m3 = new Matrix(m1.getNoRows(), m2.getNoCols());
            m3 = m1.MultiplyMatrix(m2);
            m3.DisplayMatrix();
        }



        if (choice == 3) {
            Matrix m1 = DisplayMatrix(); //? DisplayMatrix is a method of class
                                         // so it should be called like matrix.DisplayMatrix()
            Matrix m3 = new Matrix(m1.getNoRows(), m1.getNoCols());
            m3 = m1.TransposeMatrix();
            m3.DisplayMatrix();
        }

        if (choice == 4) {
            System.out.println("Will need to call the DisplyMatrix method for the object /n");
        } else {
            System.out.println("Incorrect input. Kindly enter again / n");
        }
    }

    public static Matrix MatrixReader() throws FileNotFoundException {
        System.out.println("Give the filename for the matrix");
        Scanner filescanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File(filescanner.nextLine()));
        scanner.nextLine(); // removes the first line in the input file
        String rowLine = scanner.nextLine();
        String[] arr = rowLine.split("=");
        int rows = Integer.parseInt(arr[1].trim());

        String colLine = scanner.nextLine();
        String[] arr2 = colLine.split("=");
        int cols = Integer.parseInt(arr2[1].trim());
        Matrix test = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                test.setValue(i, j, scanner.nextDouble());
            }
        }


        return test;

    }
}