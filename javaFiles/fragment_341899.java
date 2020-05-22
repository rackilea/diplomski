Map<String, Runnable> operations = new HashMap<>();
operations.put("*", this::times);
operations.put("+", this::sum);
...

Runnable operation = operations.get(calculation[i]);
if (operation != null && stack.canDoOperation()) {
    operation.run();
} else {
    operationFailed = true;
}