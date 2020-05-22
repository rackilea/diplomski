@Grab('com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.5.1')
import groovy.transform.ToString
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.*

@ToString
class Jobs {
    Integer no // XXX
    @ToString
    static class Job {
        String status
    }
    @JacksonXmlElementWrapper(useWrapping=false)
    List<Job> job
}

def xml="""<jobs><no>2</no><job><status>Completed</status></job><job><status>In Progress</status></job></jobs>"""

def xmlmapper = new XmlMapper()
def jobs = xmlmapper.readValue(xml, Jobs)
assert jobs.no==2
assert jobs.job.size()==jobs.no
assert jobs.toString()=='Jobs(2, [Jobs$Job(Completed), Jobs$Job(In Progress)])'