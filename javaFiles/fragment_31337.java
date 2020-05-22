groovy:000> ssn = 'some captured input'
===> some captured input
groovy:000> payload = '{"<Some Database Query>","Variables"{"Id":"${ssn}"}}'
===> {"<Some Database Query>","Variables"{"Id":"${ssn}"}}
groovy:000> 
groovy:000> payload = """{"<Some Database Query>","Variables"{"Id":"${ssn}"}}""" 
===> {"<Some Database Query>","Variables"{"Id":"some captured input"}}