import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class DraftCampaignActivityTest {

    @Mock
    IDraftCampaign draftCampaignI;

    @InjectMocks
    DraftCampaignActivity draftContoller;

    @Test
    @PrepareForTest(ConvertionUtil.class)
    public void createDraft_newDraft() {
        CreateDraftCampaignRequest request = new CreateDraftCampaignRequest();
        DraftCampaignDetails details = new DraftCampaignDetails();

        PowerMockito.mockStatic(ConvertionUtil.class);
        PowerMockito.when(
            ConvertionUtil.getDraftCampaignDetailsfromCreateDraftRequest(request)
        ).thenReturn(details);

        when(draftCampaignI.createDraftCampaign(details)).thenReturn(details);

        draftContoller.createDraftCampaign(request);
    }
}