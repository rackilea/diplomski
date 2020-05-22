enum Operation {
    PLUS {
        public int operate(int arg1, int arg2) {
            return arg1 + arg2;
        }
    },
    MINUS {
        public int operate(int arg1, int arg2) {
            return arg1 - arg2;
        }
    },
    ...

    abstract public int operate(int arg1, int arg2);
}

for (operation: Operations.values()) {
    if (operation.name().equals(opName))
        System.out.println("result = " + operation.operate(arg1, arg2));
        return;
    }
}
System.out.println("The Operation " + opName + " does not exist");