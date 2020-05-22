package com.ejb.test.pckg;

import java.io.Serializable;

public interface ICalculator extends Serializable {

    public int add(int a, int b);

}


package com.ejb.test.pckg;

import javax.ejb.Remote;

@Remote
public interface ICalcRemote extends ICalculator {

}

package com.ejb.test.pckg;

import javax.ejb.Stateless;

// @Stateless(mappedName = "chester")
@Stateless
public class CalcBean implements ICalcRemote {

    private static final long serialVersionUID = 5571798968598315142L;

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}