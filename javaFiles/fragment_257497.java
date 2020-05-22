import org.apache.jmeter.protocol.http.sampler.HTTPSampleResult;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;

HTTPSamplerProxy previousSampler = ctx.getPreviousSampler();
CookieManager cookieManager = previousSampler.getCookieManager();
HTTPSampleResult previousResult = (HTTPSampleResult)ctx.getPreviousResult();