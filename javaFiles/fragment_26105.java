{
    took: 10
    timed_out: false
    _shards: {
        total: 5
        successful: 5
         failed: 0
    }
    hits: {
        total: 1
        max_score: 0.30685282
        hits: [
            {
                _index: test
                _type: users
                _id: 1
                _score: 0.30685282
                _source: {
                    IPRANGE: trial
                }
            }
        ]
    }
}