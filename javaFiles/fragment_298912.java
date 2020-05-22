Generator
.combination(sides)
.simple(3)
.stream()
.forEach(
     sides -> new Triangle(sides[0],sides[1],sides[2])
);