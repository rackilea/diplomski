package com.company.product.shape;

import com.company.product.internal.shape.PointOrigoImpl;
import com.company.product.internal.shape.PointImpl;

public interface Point{
   int x();
   int y();     
   static Point of(int x, int y) {
      if (x == 0 && y == 0){
         return new PointOrigoImpl();
      }
      return new PointImpl(x, y);
  }
}