//Constraint 1
        for (int j = nDepots; j < this.allLocations.size(); j++){

            GRBLinExpr lhs = new GRBLinExpr();
            for(int i = 0; i < this.allLocations.size(); i++){
                if(i != j) {
                    for (int k = 0; k < this.vehicleList.size(); k++){
                        lhs.addTerm(1, x[i][j][k]);
                    }//k
                }
            }//i

            GRBLinExpr rhs = new GRBLinExpr();
            rhs.addConstant(1);

            model.addConstr(lhs, GRB.EQUAL, rhs, "C1 - j"+j);
        }//j