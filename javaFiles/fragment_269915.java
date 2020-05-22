@Category(Object)
class DatasetCategory {
    // A static property for holding the results of the DSL.
    static results

    def or(other) {
        if (this instanceof List) {
            // Already in a row. Add the value to the row.
            return this << other
        } else {
            // A new row.
            def row = [this, other]
            results << row
            return row
        }
    }
}

// This is the method that receives a closure with the DSL and returns the 
// parsed result.
def dataset(Closure cl) {
    // Initialize results and execute closure using the DatasetCategory.
    DatasetCategory.results = []
    use (DatasetCategory) { cl() }

    // Convert the 2D results array into a list of objects:
    def table = DatasetCategory.results
    def header = table.head()
    def rows = table.tail()
    rows.collect { row -> 
        [header, row].transpose().collectEntries { it } 
    }
}

// Example usage.
def data = dataset {
    'Key'   |    'Value'    |    'Comments'
    1       |    'foo'      |    'something'
    2       |    'bar'      |    'something else'
}

// Correcness test :)
assert data == [
    [Key: 1, Value: 'foo', Comments: 'something'],
    [Key: 2, Value: 'bar', Comments: 'something else']
]