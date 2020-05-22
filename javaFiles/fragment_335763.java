class Event {
    def code
    def name
}

def events = []
events << new Event(code: '001', name: 'a')
events << new Event(code: '002', name: 'b')

def codes = events.collect { it.code }

assert ['001','002'] == codes