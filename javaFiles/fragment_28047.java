package name.hines.steven.medical_claims_tracker.controllers;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import name.hines.steven.medical_claims_tracker.domain.Policy;
import name.hines.steven.medical_claims_tracker.services.PolicyService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/applicationContext.xml" })
public class PolicyControllerTest {

    @Mock
    PolicyService policyService;

    @InjectMocks
    PolicyController controllerUnderTest;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();

    }

    @Test
    public void createOrUpdateFailsWhenInvalidDataPostedAndSendsUserBackToForm() throws Exception {
        // POST no data to the form (i.e. an invalid POST)
        mockMvc.perform(post("/policies/persist")).andExpect(status().isOk())
        .andExpect(model().attributeHasErrors("policy"))
        .andExpect(view().name("createOrUpdatePolicy"));
    }

    @Test
    public void createOrUpdateSuccessful() throws Exception {

        when(policyService.save(isA(Policy.class))).thenReturn(new Policy());

        mockMvc.perform(
                post("/policies/persist").param("companyName", "Company Name")
                .param("name", "Name").param("effectiveDate", "2001-01-01"))
                .andExpect(status().isMovedTemporarily()).andExpect(model().hasNoErrors())
                .andExpect(redirectedUrl("list"));
    }
}