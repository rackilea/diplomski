GLPK.glp_set_row_name(lp, 2, "constraint1");
GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_FX, 0, 1.0); // equal to 1.0
GLPK.intArray_setitem(ind, 1, 1); // Add first column at first position
GLPK.intArray_setitem(ind, 2, 2); // Add second column at second position    
// set the coefficients to the variables (for all 1. except X is -1. in the example)
GLPK.doubleArray_setitem(val, 1, 1.); 
GLPK.doubleArray_setitem(val, 2, 1.);
GLPK.glp_set_mat_row(lp, 1, 2, ind, val);