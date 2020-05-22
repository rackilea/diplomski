import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.GatewayDirection;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        BpmnModelInstance modelInstance = Bpmn.createProcess()
            .name("BPMN API Invoice Process")
            .executable()
            .startEvent()
            .name("Invoice received")
            .camundaFormKey("embedded:app:forms/start-form.html")
            .userTask()
            .name("Assign Approver")
            .camundaFormKey("embedded:app:forms/assign-approver.html")
            .camundaAssignee("demo")
            .userTask()
            .id("approveInvoice")
            .name("Approve Invoice")
            .camundaFormKey("embedded:app:forms/approve-invoice.html")
            .camundaAssignee("${approver}")
            .exclusiveGateway()
            .name("Invoice approved?")
            .gatewayDirection(GatewayDirection.Diverging)
            .condition("yes", "${approved}")
            .userTask()
            .name("Prepare Bank Transfer")
            .camundaFormKey("embedded:app:forms/prepare-bank-transfer.html")
            .camundaCandidateGroups("accounting")
            .serviceTask()
            .name("Archive Invoice")
            .endEvent()
            .name("Invoice processed")
            .moveToLastGateway()
            .condition("no", "${!approved}")
            .userTask()
            .name("Review Invoice")
            .camundaFormKey("embedded:app:forms/review-invoice.html")
            .camundaAssignee("demo")
            .exclusiveGateway()
            .name("Review successful?")
            .gatewayDirection(GatewayDirection.Diverging)
            .condition("no", "${!clarified}")
            .endEvent()
            .name("Invoice not processed")
            .moveToLastGateway()
            .condition("yes", "${clarified}")
            .connectTo("approveInvoice")
            .done();

        // validate and write model to file
        Bpmn.validateModel(modelInstance);
        File file = new File("bpmn-model.bpmn.xml");
        file.createNewFile();

        String bpmnString = Bpmn.convertToString(modelInstance);
        System.out.println("bpmnString");
        System.out.println(bpmnString);

        Bpmn.writeModelToFile(file, modelInstance);
    }
}