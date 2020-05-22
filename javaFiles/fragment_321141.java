class Widget {
  List<Fizz> fizzes
}

class Fizz {
  String boron
}

w = new Widget(
  fizzes: [
    new Fizz(boron: 'boron 1'),
    new Fizz(boron: 'boron 2'),
    new Fizz()
  ]
)

nullFizzes = w.fizzes.findAll { it.boron == null }

assert nullFizzes.size() == 1

nullFizzes.each { println it }