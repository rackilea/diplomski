import org.springframework.beans.factory.annotation.{Autowired, Qualifier}
import org.springframework.core.convert.converter.ConditionalGenericConverter
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair
import org.springframework.core.convert.{ConversionService, TypeDescriptor}
import org.springframework.stereotype.Component

import scala.collection.convert.WrapAsJava

/**
 * Base functionality for option conversion.
 */
trait OptionConverter extends ConditionalGenericConverter with WrapAsJava {
  @Autowired
  @Qualifier("mvcConversionService")
  var conversionService: ConversionService = _
}

/**
 * Converts `AnyRef` to `Option[AnyRef]`.
 * See implemented methods for descriptions.
 */
@Component
class AnyRefToOptionConverter extends OptionConverter {
  override def convert(source: Any, sourceType: TypeDescriptor, targetType: TypeDescriptor): AnyRef = {
    Option(source).map(s => conversionService.convert(s, sourceType, new Conversions.GenericTypeDescriptor(targetType)))
  }

  override def getConvertibleTypes: java.util.Set[ConvertiblePair] = Set(
    new ConvertiblePair(classOf[AnyRef], classOf[Option[_]])
  )

  override def matches(sourceType: TypeDescriptor, targetType: TypeDescriptor): Boolean = {
    Option(targetType.getResolvableType).forall(resolvableType =>
      conversionService.canConvert(sourceType, new Conversions.GenericTypeDescriptor(targetType))
    )
  }
}