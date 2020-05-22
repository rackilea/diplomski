import tech.tablesaw.api.*;
import tech.tablesaw.plotly.api.*;
import tech.tablesaw.plotly.components.*;

String[] animals = {"bear", "cat", "giraffe"};
double[] cuteness = {90.1, 84.3, 99.7};

Table cuteAnimals = Table.create("Cute Animals")
    .addColumns(
        StringColumn.create("Animal types", animals),
        DoubleColumn.create("rating", cuteness)
    );
cuteAnimals