package pizza;

import java.util.*;

class TestStuff {
    public static void main(String[] args) {
        CaliforniaPizza californiaPizze = CaliforniaPizza.builder(2)
                                    .addTopping("Tomatoes").addOlives(true).build();
        SicilianPizza sicilianPizza = SicilianPizza.builder(1)
                                    .addTopping("Bacon").addCheese(false).build();

        AppleJuice appleJuice = AppleJuice.builder(40)
                                    .setPrice(120).setAlcoholVolume(0).setAppleColor("yellow").build();
        OrangeJuice orangeJuice = OrangeJuice.builder(35).setOrangeSize(8).build();
    }
}

abstract class Stuff {
    protected double price;

    protected Stuff()  {}

    protected abstract class Builder<T extends Builder<T>>  {
        protected abstract Stuff build();
        protected abstract T self();

        public T setPrice(double price)  {
            Stuff.this.price = price;
            return self();
        }
    }
}

abstract class Food extends Stuff {
    protected String mealType; //breakfast/dinner/etc

    protected Food()  {}

    public abstract class Builder<T extends Builder<T>> extends Stuff.Builder<T> {
        protected abstract Food build();
        protected abstract T self();

        public T setMealType(String mealType)  {
            Food.this.mealType = mealType;
            return self();
        }
    }
}

abstract class Pizza extends Food {
    protected List<String> toppings = new ArrayList<>();  //optional
    protected int size;  //obligatory

    protected Pizza(int size)  {this.size = size;}

    public abstract class Builder<T extends Builder<T>> extends Food.Builder<T>  {
        public T addTopping(String topping)  {
            toppings.add(topping);
            return self();
        }
    }
}

class CaliforniaPizza extends Pizza {
    private boolean addOlives;

    private CaliforniaPizza(int size) {super(size);}

    public static Builder builder(int size)  {return new CaliforniaPizza(size).new Builder();}

    public class Builder extends Pizza.Builder<Builder>  {
        @Override
        public CaliforniaPizza build()  {
            return CaliforniaPizza.this;
        }

        @Override
        public Builder self()  {return this;}

        public Builder addOlives(boolean addOlives)  {
            CaliforniaPizza.this.addOlives = addOlives;
            return this;
        }
    }
}

class SicilianPizza extends Pizza {
    private boolean addCheese;

    private SicilianPizza(int size)  {super(size);}

    public static Builder builder(int size)  {
        return new SicilianPizza(size).new Builder();
    }

    public class Builder extends Pizza.Builder<Builder>  {
        @Override
        public SicilianPizza build()  {return SicilianPizza.this;}

        @Override
        public Builder self()  {return this;}

        public Builder addCheese(boolean addCheese)  {
            SicilianPizza.this.addCheese = addCheese;
            return this;
        }
    }
}

abstract class Drink extends Stuff {
    protected double density;
    protected double alcoholVolume;

    protected Drink(double density)  {this.density = density;}

    public abstract class Builder<T extends Builder<T>> extends Stuff.Builder<T>  {
        protected abstract Drink build();
        protected abstract T self();

        public T setAlcoholVolume(double alcoholVolume)  {
            Drink.this.alcoholVolume = alcoholVolume;
            return (T) self();
        }
    }
}

abstract class Juice extends Drink {
    private String color;

    protected Juice(double density)  {super(density);}

    public abstract class Builder<T extends Builder<T>> extends Drink.Builder<T>  {
        public Builder<T> setColor(String color)  {
            Juice.this.color = color;
            return self();
        }
    }
}
class AppleJuice extends Juice {
    private String appleColor;

    private AppleJuice(double density)  {super(density);}

    public static Builder builder(double density)  {return new AppleJuice(density).new Builder();}

    public class Builder extends Juice.Builder<Builder>  {
        @Override
        public AppleJuice build()  {
            return AppleJuice.this;
        }

        @Override
        public Builder self()  {
            return this;
        }

        public Builder setAppleColor(String appleColor)  {
            AppleJuice.this.appleColor = appleColor;
            return this;
        }
    }
}

class OrangeJuice extends Juice{
    private int orangeSize;

    private OrangeJuice(double density)  {super(density);}

    public static Builder builder(double density)  {return new OrangeJuice(density).new Builder();}

    public class Builder extends Juice.Builder<Builder>  {
        @Override
        public OrangeJuice build()  {return OrangeJuice.this;}

        @Override
        public Builder self()  {return this;}

        public Builder setOrangeSize(int orangeSize)  {
            OrangeJuice.this.orangeSize = orangeSize;
            return this;
        }
    }
}