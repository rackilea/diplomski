@Grab('org.gperfutils:gbench:0.4.3-groovy-2.4')

int max = 10000

new groovyx.gbench.BenchmarkBuilder().run {
    'Array' {
        String[] s = new String[max]
        max.times { int idx ->
            s[idx] = Integer.toString(idx)
        }  
    }
    'List' {
        def s = []
        max.times{
            s << "${it}"
        }  
    }
    'Map' {
        Map m = [:]
        max.times {
            m[it] = "${it}"
        }
    }
}.prettyPrint()