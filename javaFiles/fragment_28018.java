Integer value = places.get("London");
if (value == null) {
   value = 1;
} else {
   value += 1;
}

places.put("London", value);