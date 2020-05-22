target    := foo
test      := test.out
expected  := expected.out

JAVAC     := javac
JAVAFLAGS :=
JRE       := java

main.o $(target).o: %.o: %.h
$(target): $(target).o main.o

%.class: %.java
    $(JAVAC) $(JAVAFLAGS) $^

$(TEST_OUT): $(target).class
    $(JRE) $< > $@

.PHONY: java-test clean

java-test: $(TEST_OUT) $(EXP_OUT)
    diff -q $^

clean: ; $(RM) $(target).o main.o $(target) $(target).class