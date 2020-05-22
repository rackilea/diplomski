import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    public void test() {
        QueueA queueA = new QueueA(1L);
        ElementA elementA = new ElementA(1L, queueA);
        queueA.getElements().add(elementA);
        em.persist(queueA);
        em.persist(elementA);

        QueueB queueB = new QueueB(2L);
        ElementB elementB = new ElementB(2L, queueB);
        queueB.getElements().add(elementB);
        em.persist(queueB);
        em.persist(elementB);

        List queues = em.createQuery("SELECT q FROM Queue q").getResultList();

        assertThat(queues).containsOnly(queueA, queueB);

        List elements = em.createQuery("SELECT e FROM Element e").getResultList();

        assertThat(elements).containsOnly(elementA, elementB);
    }
}

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Queue<T extends Element<T>> {

    @Id
    private Long id;

    @OneToMany(mappedBy = "queue", targetEntity = Element.class)
    private List<T> elements = new ArrayList<>();

    public Queue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Element<T extends Element<T>> {

    @Id
    private Long id;

    @ManyToOne(targetEntity = Queue.class)
    private Queue<T> queue;

    public Element(Long id, Queue<T> queue) {
        this.id = id;
        this.queue = queue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Queue<T> getQueue() {
        return queue;
    }

    public void setQueue(Queue<T> queue) {
        this.queue = queue;
    }
}

@Entity
class QueueA extends Queue<ElementA> {

    public QueueA(Long id) {
        super(id);
    }
}

@Entity
class ElementA extends Element<ElementA> {

    public ElementA(Long id, Queue<ElementA> queue) {
        super(id, queue);
    }
}

@Entity
class QueueB extends Queue<ElementB> {

    public QueueB(Long id) {
        super(id);
    }
}

@Entity
class ElementB extends Element<ElementB> {

    public ElementB(Long id, Queue<ElementB> queue) {
        super(id, queue);
    }
}