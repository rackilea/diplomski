int counter = 0
while(scheduleListIterator.hasNext())
        {
            counter++
            event = scheduleListIterator.next()
            // do stuff
            event.save flush:counter % 500
        }