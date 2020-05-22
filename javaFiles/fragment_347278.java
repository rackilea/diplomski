// and this function below is to find maximum number in ArrayList
    outerloop: 
    for (int g = (al.size()-1); g == 0; g--) {
                for (int j = 0; j <=(g-1); j++) {
                    if (al.get(j) > al.get(g)) {
                        break;
                    }
                    else if(j == (g-1)) {
                        if (al.get(g) > al.get(j)){
                            d = al.get(g);
                            break outerloop;
                        }
                    }
                } //for^2
    } // for
return d;
} // priceisright